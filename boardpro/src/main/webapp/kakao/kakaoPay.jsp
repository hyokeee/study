<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="sendPaymentRequest()">결제 요청</button>
<script>
function sendPaymentRequest() {
    var paymentData = {
        cid: "YOUR_CID",
        partner_order_id: "TC0ONETIME",
        partner_user_id: "hyokee",
        item_name: "영화표",
        quantity: 1,
        total_amount: 15000,
        tax_free_amount: 0,
        approval_url: "http://localhost:8080/kakaoPaySuccess",
        cancel_url: "http://localhost:8080/cancel",
        fail_url: "http://localhost:8080/fail"
    };

    $.ajax({
        url: "카카오페이 API URL",
        type: "POST",
        headers: {
            "Authorization": "0307c53ef7cb46ae1e61ce1be42f145f",
            "Content-Type": "application/x-www-form-urlencoded"
        },
        data: paymentData,
        success: function(response) {
            // 성공적인 응답 처리
            console.log(response);
        },
        error: function(xhr, status, error) {
            // 오류 처리
            console.log(error);
        }
    });
}

</script>
</body>
</html>