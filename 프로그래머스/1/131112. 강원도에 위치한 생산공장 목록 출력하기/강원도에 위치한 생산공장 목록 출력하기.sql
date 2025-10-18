SELECT factory_id AS FACTORY_ID,
        factory_name AS FACTORY_NAME, 
        address AS ADDRESS
FROM food_factory
WHERE address LIKE '강원도%'
ORDER BY factory_id;