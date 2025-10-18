SELECT dr_name, dr_id, mcdp_cd, TO_CHAR(hire_ymd, 'YYYY-MM-DD')
FROM doctor
WHERE mcdp_cd IN ('GS', 'CS')
ORDER BY hire_ymd DESC, dr_name ASC;