-- 코드를 작성해주세요
select id, fish_name, length
from fish_info i join fish_name_info n on i.fish_type=n.fish_type
where (i.fish_type, length) in (
    select fish_type, max(length) as length
    from fish_info
    group by fish_type
)
order by id