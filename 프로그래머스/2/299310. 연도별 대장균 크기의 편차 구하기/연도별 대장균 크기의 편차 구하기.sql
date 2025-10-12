-- 코드를 작성해주세요
select year(e.differentiation_date) as year , m.max-e.size_of_colony as year_dev, e.id
from ecoli_data e
join (
 select year(differentiation_date) as year, max(size_of_colony) as max
    from ecoli_data
    group by year
) m on year(e.differentiation_date)=m.year
order by year, year_dev