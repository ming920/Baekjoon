SELECT DISTINCT o1.user_id, o1.product_id 
FROM online_sale o1
JOIN online_sale o2
    ON o1.user_id = o2.user_id 
    AND o1.product_id = o2.product_id
    AND o1.online_sale_id != o2.online_sale_id
ORDER BY user_id, product_id DESC;