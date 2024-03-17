// 지도 마커 태그들: 도착지
const $human = document.querySelector('#human');
const $biz = document.querySelector('#biz');
const $law = document.querySelector('#law');
const $sci = document.querySelector('#sci');
const $engr = document.querySelector('#engr');
const $dorm = document.querySelector('#dorm');
const endMarkers = [$human, $biz, $law, $sci, $engr, $dorm];

let currentplace;
let currentplaceID;
let destination;
let destinationID;
let permitNext = false;
let startPoint;
let startPointID;

// 드롭다운 요소들
const $step1 = document.querySelector('.step1');
const $dropdownbtn = document.querySelector('.dropbtn-plus');
const $dropdowntext = document.querySelector('.dropbtn');
const $endlist = document.querySelector('.endlist');
const $startlist = document.querySelector('.startlist');

// 마커 클릭 시 이벤트
let clickable = true;
function showText (value) {
    $dropdowntext.innerText = value;
    currentplace = value;
    // if (['정문', '생활환경관', '학관', '포스코관', '후문', '연구협력관'].includes(value) && ) {
    //     startPoint = value;
    // } else {
    //     currentplace = value;
    // }
    permitNext = true;
}

const clickMenuSelect = (markerArr, target, placelist) => {
    let number = 0;
    markerArr.forEach(element => {
        if (element.id === target.id) {
            number = markerArr.indexOf(element);
        } else if (element.classList.contains('clicked')) {
            element.classList.remove('clicked');
        }
    });
    clickable = false;
    const dest = placelist.querySelector(`div:nth-child(${number+1})`);
    dest.click();
    clickable = true;
}

const clickMarker = (e) => {
    // 마커 크기 커짐
    e.target.classList.add('clicked');
    currentplaceID = e.target.id;
    // 이전에 다른 마커를 클릭했었다면, 그 마커 크기 축소
    // let number = 0;
    if (!destination) clickMenuSelect(endMarkers, e.target, $endlist);
    else clickMenuSelect(startMarkers, e.target, $startlist);
    // endMarkers.forEach(element => {
    //     if (element.id === e.target.id) {
    //         number = endMarkers.indexOf(element);
    //     } else if (element.classList.contains('clicked')) {
    //         element.classList.remove('clicked');
    //     }
    // });
    // // 도착지 자동 선택
    // clickable = false;
    // const dest = $endlist.querySelector(`div:nth-child(${number+1})`);
    // dest.click();
    // clickable = true;
}
// 도착지 마커 클릭 이벤트 연결
$engr.addEventListener('click', clickMarker);
$sci.addEventListener('click', clickMarker);
$law.addEventListener('click', clickMarker);
$biz.addEventListener('click', clickMarker);
$human.addEventListener('click', clickMarker);
$dorm.addEventListener('click', clickMarker);

// 드롭다운 메뉴 클릭 이벤트
const clickedClassToggle = (target, sampleArr) => {
    sampleArr.forEach(element => {
        // array에 $hak 들어있고 currentplace가 $human인 경우 이벤트 막기
        if (element.classList.contains(target.className)) {
            if (sampleArr.includes($hak) && destination === '생활환경관' && target.className === 'listHuman') {
                alert("'생활환경관'은 이미 도착지로 선택되었습니다.");
            } else {
                element.classList.add('clicked');
                currentplaceID = element.id;
                // if (!sampleArr.includes($hak)) destinationID = element.id;
                // else startPointID = element.id;
                // placeID = element.id;
                sampleArr.forEach(element2 => {
                    if (element2.id !== element.id && element2.classList.contains('clicked')) {
                        element2.classList.remove('clicked');
                    }
                });
            }
        }
    });
}
$dropdownbtn.addEventListener('click', (e) => {
    if (!clickable) return;
    if ($step1.innerText !== '출발지:') {
        // 도착지 설정인 경우 (step1)
        $endlist.style.display = $endlist.style.display === 'none' ? '' : 'none';
        clickedClassToggle(e.target, endMarkers);
    } else {
        // 출발지 설정인 경우 (step2)
        $startlist.style.display = $startlist.style.display === 'none' ? '' : 'none';
        clickedClassToggle(e.target, startMarkers);
    }
});


// 지도 마커 태그들: 출발지
const $maingate = document.querySelector('#main-gate');
const $hak = document.querySelector('#hak');
const $posco = document.querySelector('#posco');
const $backgate = document.querySelector('#back-gate');
const $research = document.querySelector('#research');
const startMarkers = [$maingate, $human, $hak, $posco, $backgate, $research];

// 출발지 마커 클릭 이벤트 연결
$backgate.addEventListener('click', clickMarker);
$hak.addEventListener('click', clickMarker);
$posco.addEventListener('click', clickMarker);
$maingate.addEventListener('click', clickMarker);
$research.addEventListener('click', clickMarker);

// '다음으로' 버튼
const $nextBtn = document.querySelector('.next-btn');
const $okayBtn = document.querySelector('.okay-btn');
$nextBtn.addEventListener('click', (e) => {
    // 도착지 선택 전인 경우 alert
    if (!permitNext) {
        alert('도착지를 선택해 주세요.');
        return;
    }
    permitNext = false;
    // destination, destinationID 현재 위치로 확정
    // NextBtnClicked = true;
    destination = currentplace;
    destinationID = currentplaceID;
    // 도착지 마커들 사라짐 (선택된 도착지 마커와 생활관 제외)
    endMarkers.forEach(element => {
        if (element !== $human && element.id !== destinationID) {
            element.style.display = 'none';
        }
    });
    // 출발지 마커 더 이상 못 누르게 이벤트 해제
    // 생활관은 도착지로 선택된 경우에만 이벤트 해제
    if (destination === '생활환경관') {
        $human.removeEventListener('click', clickMarker);
        document.querySelector('.startlist div:nth-child(2)').removeAttribute('onclick');
    } else {
        document.querySelector(`#${destinationID}`).removeEventListener('click', clickMarker);
    }
    // 선택한 도착지 마커 아이콘 크기 복구
    document.querySelector(`#${destinationID}`).classList.remove('clicked');

    // 출발지 마커들 나타남
    startMarkers.forEach(element => {
        if (element === $human && destination !== '생활환경관') {
            element.style.color = 'darkgreen';
        } else element.style.display = 'block';
    });

    // 출발지 드롭다운 메뉴로 바뀜
    $step1.innerText = '출발지: ';
    $dropdowntext.innerText = '...';

    $nextBtn.style.display = 'none';
    $okayBtn.style.display = '';
});
// '길 찾기' 버튼 클릭
$okayBtn.addEventListener('click', (e) => {
    if (!permitNext) {
        alert('출발지를 선택해 주세요.');
        return;
    }
    startPoint = currentplace;
    startPointID = currentplaceID;
    
    // 데이터 보내기
    // 전달할 데이터
    const DestInfo = {
        destination: destination,
        startPoint: startPoint,
    }
    localStorage.setItem("user-info", JSON.stringify(DestInfo));
    window.location = 'PathGuide.html';
});