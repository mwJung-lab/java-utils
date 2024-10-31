http://localhost:10060/swagger-ui.html
http://tcw.mannashop.co.kr:8080/foodtech/swagger-ui.html
https://cw.mannashop.co.kr:8443/foodtech/swagger-ui.html

-------------------------
PF_TYPE_CD KEY 정보
-------------------------
PF_TYPE_CD : 1001
TEST KEY : iBX8RAiafpTPLGYBwkcWcQ==
REAL KEY : u8+R1HipXIovQVCeDabTXw==

//대행요금확인 (DTM_FEE_SEARCH)
{
"data":{"in_CENTER_CODE":"1","in_SHOP_CODE":"UNITAS-1001-jgchoi","in_VENDOR_CODE":"S000350","in_ORDER_CODE":"1","in_RCV_ADDR1":"서울","in_RCV_ADDR2":"동작구","in_RCV_ADDR3":"","in_RCV_GPS_LNG":"0","in_RCV_GPS_LAT":"0","in_RCV_DISTANCE":"0","in_ORDER_AMT":"0"},
  "header": {
    "copartner_code": "MANNA",
    "result_code": "",
    "result_message": "",
    "service_code": "DTM_FEE_SEARCH"
  }
}

//배송요청 (DTM_REG)
{
  "data": {"in_ACTION_KIND":"1","in_ORDER_CODE":"1","in_CENTER_CODE":"1","in_SHOP_CODE":"UNITAS-1001-jgchoi","in_VENDOR_CODE":"S000350","in_SHOP_TEL":"","in_SHOP_ADDR1":"","in_SHOP_ADDR2":"","in_SHOP_ADDR3":"","in_SHOP_LNG":"0","in_SHOP_LAT":"0","in_ORDER_CU_TEL":"01012341234","in_ORDER_CU_NM":"","in_ORDER_RCV_TEL":"","in_ORDER_RCV_NM":"","in_RCV_ADDR1":"서울","in_RCV_ADDR2":"동작구","in_RCV_ADDR3":"","in_RCV_GPS_LNG":"0","in_RCV_GPS_LAT":"0","in_ORDER_AMT":"1","in_PAYMENT":"01","in_ORDER_DATA":[{"in_SUB_GOODS_NM":"가나다라", "in_SUB_EA":"1", "in_SUB_SALE_PRICE":"1"}],"in_DVRY_MSG":"","in_DVRY_OFFICE_MSG":"","in_DVRY_PICKUP_TIME":"","in_DVRY_DISTANCE":"0","in_DVRY_FEE":"0","in_DVRY_COUNT_FEE":"0"},
  "header": {
    "copartner_code": "MANNA",
    "result_code": "",
    "result_message": "",
    "service_code": "DTM_REG"
  }
}

//배송상세조회 (DTM_DETAIL)
{
"data":{"in_CENTER_CODE":"1","in_SHOP_CODE":"UNITAS-1001-jgchoi","in_VENDOR_CODE":"S000350","in_ORDER_CODE":"1"},
  "header": {
    "copartner_code": "MANNA",
    "result_code": "",
    "result_message": "",
    "service_code": "DTM_DETAIL"
  }
}

//예치금 잔액 확인 (DTM_ADVANCED_PAYMENTS_SEARCH)
{
"data":{"in_CENTER_CODE":"1","in_SHOP_CODE":"UNITAS-1001-jgchoi","in_VENDOR_CODE":"S000350"},
  "header": {
    "copartner_code": "MANNA",
    "result_code": "",
    "result_message": "",
    "service_code": "DTM_ADVANCED_PAYMENTS_SEARCH"
  }
}

// 매장 연동 (신버전)
{
  "in_ST_CODE": "S285589",
  "in_POS_CON_YN": "Y",
  "in_POS_SHOP_CODE": "mawang-1001-qadpos06"
}
