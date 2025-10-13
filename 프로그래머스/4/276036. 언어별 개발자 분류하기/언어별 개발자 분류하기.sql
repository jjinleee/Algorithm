WITH flags AS (
  SELECT
    d.id,
    d.email,
    -- Front End 스킬 보유 여부(개수>0)
    SUM(CASE WHEN s.category = 'Front End' AND (d.skill_code & s.code) <> 0 THEN 1 ELSE 0 END) AS has_fe,
    -- Python 보유 여부
    MAX(CASE WHEN s.name = 'Python' AND (d.skill_code & s.code) <> 0 THEN 1 ELSE 0 END) AS has_python,
    -- C# 보유 여부
    MAX(CASE WHEN s.name = 'C#' AND (d.skill_code & s.code) <> 0 THEN 1 ELSE 0 END) AS has_csharp
  FROM developers d
  JOIN skillcodes s
    ON (d.skill_code & s.code) <> 0
  GROUP BY d.id, d.email
)
SELECT
  CASE
    WHEN has_fe > 0 AND has_python = 1 THEN 'A'
    WHEN has_csharp = 1 THEN 'B'
    WHEN has_fe > 0 THEN 'C'
  END AS grade,
  id,
  email
FROM flags
WHERE
  -- 등급이 존재하는 개발자만
  (has_fe > 0 AND has_python = 1) OR
  (has_csharp = 1) OR
  (has_fe > 0)
ORDER BY grade, id;