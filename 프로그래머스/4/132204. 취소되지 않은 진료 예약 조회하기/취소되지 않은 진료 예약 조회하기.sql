-- 코드를 입력하세요
SELECT apnt_no, pt_name, a.pt_no, d.mcdp_cd, dr_name,  apnt_ymd
from doctor d join appointment a on d.dr_id=a.mddr_id
join patient p on a.pt_no=p.pt_no
where a.mcdp_cd='CS' and apnt_ymd like '2022-04-13%' and apnt_cncl_yn='N'
order by apnt_ymd
