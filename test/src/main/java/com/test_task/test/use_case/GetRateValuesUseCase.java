package com.test_task.test.use_case;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test_task.test.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.test_task.test.common.JsonTag.COUNTRY;
import static com.test_task.test.common.JsonTag.RATES;
import static com.test_task.test.common.JsonTag.STANDARD_RATE;

@Service
@RequiredArgsConstructor
public class GetRateValuesUseCase {

    private final RestService restService;
    private final List<String> listOfCountryCode = Arrays.asList("AT", "BE", "BG", "CY", "CZ", "DK", "DE", "EE", "EL", "GR", "ES", "FI", "FR", "HR", "IT", "LV", "LT", "LU", "HU", "IE", "MT", "NL", "PL", "PT", "RO", "SI", "SK", "SE", "UK", "GB");

    public List<String> execute() {

        var result = restService.getPostPlainJSON();
        JsonParser jsonParser = new JsonParser();
        Map<String, Integer> map = new HashMap<>();
        JsonObject object = jsonParser.parse(result).getAsJsonObject().get("rates").getAsJsonObject();

        listOfCountryCode.forEach(
                countryCode -> {
                    var nextJson = object.get(countryCode);
                    var jsonObject = nextJson.getAsJsonObject();
                    map.put(jsonObject.get(COUNTRY).getAsString(), jsonObject.get(STANDARD_RATE).getAsInt());
                }
        );
        var sortedMap = entriesSortedByValues(map);
        var listOf = sortedMap.stream().map(Map.Entry::getKey).toList();

        return Arrays.asList(listOf.get(listOf.size() - 1), listOf.get(listOf.size() - 2), listOf.get(0), listOf.get(1));
    }

  private SortedSet<Map.Entry<String, Integer>> entriesSortedByValues(Map<String, Integer> map) {
        SortedSet<Map.Entry<String, Integer>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
