
let clickCount = parseInt(localStorage.getItem('json')) || 0;
const maxCount = 30000; // 최대 값
const counterImage = document.getElementById("spy");

// JSON 데이터를 화면에 표시
var jsonDataDisplay = document.getElementById('jsonDataDisplay');
const dataDisplay = document.getElementById('dataDisplay');

//function increase() {
//    if (count < maxCount) {
//        count += 1;
//        localStorage.setItem('json', JSON.stringify(count));
//    }
//    //console.log(count);
//}

//    // 이미지 클릭 이벤트 처리
//    counterImage.addEventListener("click", () => {
//        increase();
//        sendDataToServer();
//    });

function incrementCount() {
   if (clickCount < maxCount) {
          clickCount += 1;
          updateCountDisplay();
          localStorage.setItem('json', JSON.stringify(count));
          //toggleImage();
      }
      console.log(count);
}

document.getElementById("spy").addEventListener("click", function () {
    increase();

});

function updateCountDisplay() {
    clickCount.textContent = clickCount;
    const fillPercentage = (clickCount / maxCount) * 100;
    countNum.textContent = `${count} / ${maxCount} 원`; // count 값 / 30,000 형식으로 표시
    //fill.style.width = `${fillPercentage}%`;
}

//
//// 초기값을 서버에서 가져오는 함수
//function getInitialCount() {
//    fetch('/displayCount', {
//        method: 'GET',
//        headers: {
//                'Accept': 'application/json' // JSON 응답을 요청
//            }
//    })
//    .then(function(response) {
//        if (response.status === 200) {
//            return response.json();
//        } else {
//            throw new Error('초기값을 가져오는 중 오류가 발생했습니다.');
//        }
//    })
//    .then(function(data) {
//        // 서버에서 받은 초기값을 화면에 표시
//        display(data);
//    })
//    .catch(function(error) {
//        console.error('오류: ' + error);
//    });
//}
//
//// 클릭 이벤트 핸들러
//function handleButtonClick() {
//    if (count < maxCount) {
//        count += 1;
//        sendDataToServer(count); // 클릭 수를 서버로 전송
//    }
//}
//
//
//function sendDataToServer(){
//// Local Storage에서 데이터를 가져옴
//var data = localStorage.getItem('json');
//
//// 서버로 데이터를 보냄
//fetch('/counts/increase', {
//  method: 'POST', // POST 요청을 사용하거나 GET, PUT, DELETE 등 다른 HTTP 메서드를 선택할 수 있습니다.
//  headers: {
//    'Content-Type': 'application/json', // JSON 데이터를 보내는 경우 Content-Type을 설정
//  },
//  body: JSON.stringify({ count: count }), // 데이터를 JSON 문자열로 변환하여 보냄
//})
//  .then(function(response) {
//    if (response.status === 200) {
//      // 서버에서 성공적인 응답을 받았을 때 수행할 작업
//      console.log('데이터가 서버로 전송되었습니다.');
//      console.log('서버에서 반환된 데이터:', data);
//      return response.json();
//    } else {
//      // 서버에서 오류 응답을 받았을 때 수행할 작업
//      console.error('서버로 데이터 전송 중 오류가 발생했습니다.');
//      throw new Error('클릭 수를 서버로 전송하는 중 오류가 발생했습니다.');
//    }
//  })
//  .catch(function(error) {
//    // Fetch API에서 발생한 오류를 처리
//    console.error('오류: ' + error);
//  });
//}
//
////주기적으로 sendDataToServer 함수를 호출 (10초마다)
//setInterval(sendDataToServer, 10000);
//
//function display(data) {
//    // JSON 데이터를 화면에 표시
//    var jsonDataDisplay = document.getElementById('jsonDataDisplay');
//
//    // JSON 데이터를 예쁘게 포맷팅하고 표시
//    jsonDataDisplay.textContent = JSON.stringify(data, null, 2);
//
//    var clickCountDisplay = document.getElementById('clickCountDisplay');
//        clickCountDisplay.textContent = data.num;
//}
//
//// 초기화 함수
//function initialize() {
//    getInitialCount(); // 초기값을 서버에서 가져오고 화면에 표시
//    // 클릭 이벤트 리스너를 설정
//    var button = document.getElementById('clickButton');
//    button.addEventListener('click', handleButtonClick);
//}
//
//initialize(); // 페이지 로드 시 초기화 함수 실행
