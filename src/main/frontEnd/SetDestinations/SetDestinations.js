// 지도 마커 태그들: 도착지
const $human = document.querySelector('#human');
const $biz = document.querySelector('#biz');
const $law = document.querySelector('#law');
const $sci = document.querySelector('#sci');
const $engr = document.querySelector('#engr');
const $dorm = document.querySelector('#dorm');
const startMarkers = [$human, $biz, $law, $sci, $engr, $dorm];

// 드롭다운 요소들
const $dropdownbtn = document.querySelector('.dropbtn-plus');
const $dropdowntext = document.querySelector('.dropbtn');
const $dropdownContent = document.querySelector('.dropdown-content');

// 마커 클릭 시 이벤트
let clickable = true;
function showText (value) {
    $dropdowntext.innerText = value;
}
const clickMarker = (e) => {
    // 마커 크기 커짐
    e.target.classList.add('clicked');
    // 이전에 다른 마커를 클릭했었다면, 그 마커 크기 축소
    let number = 0;
    startMarkers.forEach(element => {
        if (element.id === e.target.id) {
            number = startMarkers.indexOf(element);
        } else if (element.classList.contains('clicked')) {
            element.classList.remove('clicked');
        }
    });
    // 도착지 자동 선택
    clickable = false;
    const dest = $dropdownContent.querySelector(`div:nth-child(${number+1})`);
    dest.click();
    clickable = true;
}
// 도착지 마커 클릭 이벤트 연결
$engr.addEventListener('click', clickMarker);
$sci.addEventListener('click', clickMarker);
$law.addEventListener('click', clickMarker);
$biz.addEventListener('click', clickMarker);
$human.addEventListener('click', clickMarker);
$dorm.addEventListener('click', clickMarker);

// 드롭다운 메뉴 클릭 이벤트
$dropdownbtn.addEventListener('click', (e) => {
    if (!clickable) return;
    $dropdownContent.style.display = $dropdownContent.style.display === 'none' ? '' : 'none';
    startMarkers.forEach(element => {
        if (element.classList.contains(e.target.className)) {
            element.classList.add('clicked');
            startMarkers.forEach(element2 => {
                if (element2.id !== element.id && element2.classList.contains('clicked')) {
                    element2.classList.remove('clicked');
                }
            });
        }
    })
});

// '다음으로' 버튼
const $nextBtn = document.querySelector('.next-btn');
$nextBtn.addEventListener('click', (e) => {

});



// 지도 마커 태그들: 출발지
const $backgate = document.querySelector('#back-gate');
const $hak = document.querySelector('#hak');
const $posco = document.querySelector('#posco');
const $maingate = document.querySelector('#main-gate');
const $research = document.querySelector('#research');
// $backgate.addEventListener('click', clickMarker);
// $hak.addEventListener('click', clickMarker);
// $posco.addEventListener('click', clickMarker);
// $maingate.addEventListener('click', clickMarker);
// $research.addEventListener('click', clickMarker);