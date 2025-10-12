-- 코드를 작성해주세요
select i.id, n.fish_name, i.length
from fish_info i
join fish_name_info n on i.fish_type=n.fish_type
join (
    select fish_type, max(length)as max
    from fish_info
    group by fish_type
) m on i.length=m.max and i.fish_type=m.fish_type
order by id