const $B1Res = document.querySelector('.B1Res');
const $B1img = document.querySelector('#B1img');
const $B2HWR = document.querySelector('.B2HWR');
const $B2img = document.querySelector('#B2img');
const $B3Nght = document.querySelector('.B3Nght');
const $B3img = document.querySelector('#B3img');

const onClickEvent = (e) => {
    // 클릭하면 박스 색 바뀌며 이미지 토글: 클래스 토글
    e.target.classList.toggle('clicked');
    if (e.target.textContent.includes('연구협력관')) {
        // $B1img.classList.toggle('imgClicked');
        $B1img.style.display = $B1img.style.display === 'none' ? '' : 'none';
    } else if (e.target.textContent.includes('한우리집')) {
        $B2img.style.display = $B2img.style.display === 'none' ? '' : 'none';
    } else $B3img.style.display = $B3img.style.display === 'none' ? '' : 'none';
}

$B1Res.addEventListener('click', onClickEvent);
$B2HWR.addEventListener('click', onClickEvent);
$B3Nght.addEventListener('click', onClickEvent);