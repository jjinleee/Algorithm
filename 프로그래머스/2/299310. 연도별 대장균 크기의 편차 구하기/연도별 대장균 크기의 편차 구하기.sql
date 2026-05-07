-- 코드를 작성해주세요
with big as (
    select year(differentiation_date) as year, max(size_of_colony) as maxSize
    from ecoli_data
    group by year(differentiation_date)
)
select year(differentiation_date) as year, maxSize-size_of_colony as year_dev, id
from ecoli_data e join big b on year(e.differentiation_date)=b.year
order by year, year_dev
