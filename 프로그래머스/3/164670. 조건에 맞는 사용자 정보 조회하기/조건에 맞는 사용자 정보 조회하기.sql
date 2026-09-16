-- 코드를 입력하세요
SELECT user_id, nickname, concat(city,' ',street_address1,' ',street_address2) as 전체주소, 
concat_ws('-',left(tlno,3) ,substring(tlno,4,4), right(tlno,4)) as  전화번호
from used_goods_board b join used_goods_user u on b.writer_id=u.user_id
group by user_id
having count(board_id)>=3
order by user_id desc