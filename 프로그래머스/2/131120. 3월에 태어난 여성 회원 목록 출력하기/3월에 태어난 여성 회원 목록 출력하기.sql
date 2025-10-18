SELECT 
    member_id, 
    member_name, 
    gender, 
    TO_CHAR(date_of_birth, 'YYYY-MM-DD') as date_of_birth
    
FROM member_profile
WHERE gender = 'W'
    AND tlno IS NOT NULL
    AND EXTRACT(MONTH FROM date_of_birth) = 3
ORDER BY member_id;