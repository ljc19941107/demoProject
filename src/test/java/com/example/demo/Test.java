package com.example.demo;




import com.alibaba.fastjson.*;
import com.example.demo.bean.udstand.*;
import com.example.demo.bean.user.*;
import com.example.demo.bean.user.test.ServiceValidLightData;
import com.example.demo.utils.*;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.bean.udstand.ResultOutputActionType.FEATURE_OUTPUT;
import static com.example.demo.bean.udstand.ResultOutputActionType.TAG_OUTPUT;

public class Test {

    private static Map<String, String> resultFeatureIdMap = Maps.newHashMap();
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String SUB_STRATEGY_TYPE = "subStrategyType";

    public static final String STRATEGY_CONTENT = "strategyContent";

    public static void main(String[] args) throws ParseException {
        String str = "vwNkMjAyMzEwMjYyMjAwMDUwMzc3MTUwOCMxLjAFAQAsCSAEMzAFICAzMDQ4NDU0Njk+IAANQCA2MDM5OTM0MzFaIABEOTAzNzg2MDI1IzAuOTc3MzU0DWANQAA0ASAMMTU2Mj4gABmADDk1ODJGIAANQAHAEDg1ODkzPkAABDI0DcAYMzEwOTE5MAUgCDQwNjqAABwzMDM4NzgzNF4gACA5MDM4NTEwMzlaQAAcNTAzODk1MTkJwC5gAAA3BYAgNTA0MjYyMTE2WkAAADMhgAw5MDk4PiAALQBEODA0ODc0MDc1IzAuODUzNDIw";

        String str1 = "dVh7IuWTgeexuyI6IumUgemqqCIsInNwdQEVBImMAQbwU7G755CG6Kej57uT5p6c5p2l5rqQIjoi5a6e5pe25qih5Z6LIiwi57G755uuIjoi5aSn5LyX55Sf5rS7LeS6kuWKqOiQpemUgC3mnYPnm4rljaEifQ==";

        String str2 = "mAp8eyJvdXRwdXQiOnsiaGVhZHNob3QiOltdLCJ0aGlzJDABGPBMZ29vZHNfbmFtZSI6IuiOq+avlOS5jOaWr+eOr+Wls+mUgemqqOi9u+WlouWwj+S8l+iuvuiuoeaEnyIsImFwcF9pZF9iYXNpY19saXMBXhAiLTEiXREbVCI6IjIwMjEwMDMxOTE2MDIzMTYiLCINNxExCSIkMjE2MTYzNjU5NgE/qHVybCI6ImFsaXBheXM6Ly9wbGF0Zm9ybWFwaS9zdGFydEFwcD9hcHBJZD0JPxlhFCZwYWdlPQEFNHMlMkZpdGVtRGV0YWlsPg4AADMFHHxJZCUzRDE4Mzc5NTclMjZmcm9tJTNEemZiTWluaSJ9LCkhAE7OIAE0fSwibGFiZWxfbm9kZXMhbZjlkI3np7AiOlt7InByb2JzIjowLjk5Mzk1MzE2ODM5MjE4MTQsInT+nQH+nQH+nQH+nQGmnQEMdmFsdSFbwroCIZNMSWQiOlsxM119XX0sInByZWRpY3QxrDmiAFtGowFhQQhhZ1YBfMo1A1BiYm94IjpbNTgsNjkzLDY5OCw3MjMBU/73Af73Af73Af73Aab3AQh0YWdtkhR0ZXh0Iiw1zyQxMywicGFyZW50Id0AOW2BPHMiOlsi5ZCN56ewIl19XX0=";

        UdstandResultOutputRuleRequest request = new UdstandResultOutputRuleRequest();
        request.setAttributeId("UA202305170000000001");
        request.setOutputRuleName("输出规则名称");
        request.setAuditModelJson("{\"auditConditions\":[{\"expectedValue\":[\"预期值\"],\"featureKey\":\"特征key\",\"function\":\"函数\","
                + "\"logicOperator\":\"逻辑运算符\",\"sort\":1}],\"resultAudits\":[{\"auditActionType\":\"ARTIFICIAL_AUDIT\","
                + "\"auditor\":[\"ljc01601460\",\"ljc01601461\"]},{\"auditActionType\":\"GR_AUDIT\",\"grAuditCode\":\"审核编码\"}]}");
        request.setOutputCodeJson("[{\"featureCode\":\"FT001\",\"outputActionType\":\"FEATURE_OUTPUT\"},"
                + "{\"outputActionType\":\"TAG_OUTPUT\",\"tagItemId\":\"IT001\"}]");
        request.setEvaluateModelJson("{\"evaluatePeriod\":\"ONCE_MONTH_EVALUATE\",\"evaluateReport\":\"http://\"}");




    }

    private static Integer convert(Integer integer){
        if (integer < 10) {
            return integer;
        }
        String priorityStr = String.valueOf(integer);
        String preStr = priorityStr.substring(0, priorityStr.length() - 1);

        StringBuilder stringBuffer = new StringBuilder();
        //最大值限制 优先级最大999999999 既 89
        int pre = Integer.parseInt(preStr);
        pre = Math.min(pre, 8);
        for (int i = 0; i < pre; i++) {
            stringBuffer.append("9");
        }
        stringBuffer.append(priorityStr.substring(priorityStr.length() - 1));
        return Integer.parseInt(stringBuffer.toString());
    }





    private static Map<String, Object> convert(Map<String, Object> param) {
        Object jsUrlContent = param.get("jsUrlContent");
        //入参
        JSONArray jsonArray = JSONArray.parseArray(jsUrlContent.toString());
         JSONObject jsonObject = (JSONObject)JSONObject.toJSON(jsonArray.get(3));
         JSONObject jsonObject1 = (JSONObject)JSONObject.toJSON(jsonObject.get("res"));
         Object k = jsonObject1.get("skus");

        JSONArray jsonReturnArray = new JSONArray();
        Map<String, Object> resultMap = new HashMap<>();


        // //将其中的data部分的jsonarray取出来
         JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(k));
         if (array.size() > 0) {
             for (int i = 0; i < array.size(); i++) {
                 Map<String, Object> arrayMap = new HashMap<>();
                 // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                 JSONObject job = array.getJSONObject(i);
                 System.out.println(job.get("salePrice"));
                 arrayMap.put("original_price",job.get("originalPrice"));
                 arrayMap.put("price",job.get("salePrice"));
                 arrayMap.put("image",job.get("image"));
                 arrayMap.put("stock_num",job.get("stock"));
                 arrayMap.put("sku_attrs",job.get("skuAttrsPath"));

             }
         }
        resultMap.put("result",jsonReturnArray);

        //返回
        resultMap.put("result",jsonArray);
        return resultMap;
    }

    private static Integer getAlgoCateNameList1(int algoCateName) {
        try {
            algoCateName = 1;
            return algoCateName;
        }catch (Exception e) {
            algoCateName = 2;

        }finally {
            algoCateName = 3;

        }
        return algoCateName;
    }

    private static List<String> getAlgoCateNameList(String algoCateName) {
        List<String> list = Lists.newArrayList();
        list.add(algoCateName);
        for (int i = 0; i < 4; i++) {
            if (StringUtils.isBlank(algoCateName) || !algoCateName.contains("-")) {
                break;
            }
            String substring = algoCateName.substring(0, algoCateName.lastIndexOf("-"));
            algoCateName = substring;
            list.add(algoCateName);
        }


        return list;
    }

    public static void test123() {
        List<String> list = Lists.newArrayList();

        String               invisibleStrategyType                   = "{\"UDSTAND_TASK_STRATEGY\":\"\",\"CALCULATE_STRATEGY\":\"\","
                + "\"COLLECT_STRATEGY\":\"\"}";
        Map<String, String>  invisibleStrategyTypeMap                = JSONObject
                .parseObject(invisibleStrategyType, Map.class);
        for (String value : invisibleStrategyTypeMap.values()) {
            list.addAll(ListUtils.convertStringToList(value, ','));
        }
        System.out.println(list);
        System.out.println(list.contains("SPECIFY_PLATFORM"));


    }

    public static String filterVisibleStrategy(String strategies) {
        //非超级管理员不可见策略类型集合
        List<String> invisibleStrategyTypeList =  Lists.newArrayList("EFFICIENT_PERIOD");
        JSONArray jsonArray = JSONObject.parseArray(strategies);
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            String strategyType = jsonObject.getString(SUB_STRATEGY_TYPE);
            if (invisibleStrategyTypeList.contains(strategyType)) {
                iterator.remove();
            }
        }
        return jsonArray.toJSONString();
    }


    public static JSONArray setInvisibleStrategyContent(JSONArray targetArray, JSONArray originalArray) {
        //非超级管理员不可见策略类型集合
        List<String> invisibleStrategyTypeList = Lists.newArrayList("EFFICIENT_PERIOD","PRIORITY_LEVEL");
        if (CollectionUtils.isEmpty(invisibleStrategyTypeList)) {
            return targetArray;
        }

        for (Object original : originalArray) {
            //原始策略
            JSONObject originalObject = (JSONObject) original;
            String subStrategyType = originalObject.getString(SUB_STRATEGY_TYPE);
            //若策略类型属于非超级管理员不可见的策略类型, 则取原始策略的策略值赋值给补全后的策略
            if (invisibleStrategyTypeList.contains(subStrategyType)) {
                //策略内容
                Object strategyContent = originalObject.get(STRATEGY_CONTENT);
                //补全后的策略
                for (Object target : targetArray) {
                    JSONObject jsonObject = (JSONObject) target;
                    if (StringUtils.equals(subStrategyType,
                            jsonObject.getString(SUB_STRATEGY_TYPE))) {
                        jsonObject.put(STRATEGY_CONTENT, strategyContent);
                    }
                }
            }
        }
        return targetArray;
    }

    public static void test1() {
        String url = "{\"resultId\":\"19914\",\"processAfterResult\":[{\"nodeName\":\"商品标签抽取\",\"nodeFeatureId\":\"19914\",\"label\":[],\"version\":\"v0\",\"algorithmServiceCode\":\"datacube-21550\",\"status\":\"OK\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(url);
        JSONArray processAfterResult = jsonObject.getJSONArray("processAfterResult");
        JSONObject jsonObject1 = JSONObject.parseObject(processAfterResult.get(0).toString());
        String label = jsonObject1.getString("label");
        System.out.println(StringUtils.equals("[]", label));
        System.out.println(label);
    }
    public static void formatDuring1() {

    }

    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }


    private static void test() {
        List<String> strings = Arrays.asList("abc", "abc", "bc", "efg", "abcd", "jkl", "jkl");
        List<String> collect = strings.stream().map(str -> str + "-itcast").collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        List<String> sorted1 = strings.stream().sorted().collect(Collectors.toList());

        List<String> limited = strings.stream().limit(3).collect(Collectors.toList());

        List<String> skiped = strings.stream().skip(3).collect(Collectors.toList());

        Optional<String> reduce = strings.stream().reduce((acc, item) -> acc + item);
        reduce.ifPresent(System.out::println);
    }
}
