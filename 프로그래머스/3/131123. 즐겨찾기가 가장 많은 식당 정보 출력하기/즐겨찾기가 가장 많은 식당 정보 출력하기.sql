select r.food_type, r.rest_id, r.rest_name, r.favorites
from rest_info r join (
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type
) as m
on r.food_type=m.food_type and
r.favorites=m.favorites 
order by food_type desc

