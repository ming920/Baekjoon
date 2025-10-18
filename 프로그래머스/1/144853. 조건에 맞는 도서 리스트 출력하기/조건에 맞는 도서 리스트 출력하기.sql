SELECT book_id, TO_CHAR(published_date, 'YYYY-MM-DD') as published_date
FROM book
WHERE published_date >= DATE '2021-01-01' 
    AND published_date <= DATE '2021-12-31'
    AND category = '인문'
ORDER BY published_date;