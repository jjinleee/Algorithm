-- 코드를 입력하세요
SELECT '/home/grep/src/' || b.board_id || '/' || file_id || file_name || file_ext
from used_goods_board b join used_goods_file f on b.board_id=f.board_id
where views = (
    select max(views)
    from used_goods_board
)
order by file_id desc