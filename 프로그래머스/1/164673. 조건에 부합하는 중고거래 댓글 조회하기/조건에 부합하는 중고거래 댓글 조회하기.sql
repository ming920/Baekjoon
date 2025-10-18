SELECT 
    b.title, 
    b.board_id, 
    r.reply_id, 
    r.writer_id, 
    r.contents, 
    TO_CHAR(r.created_date, 'YYYY-MM-DD') AS created_date 
FROM used_goods_board b
JOIN used_goods_reply r
    ON b.board_id = r.board_id
WHERE b.created_date >= DATE '2022-10-01' AND b.created_date <= DATE '2022-10-31'
ORDER BY r.created_date ASC, b.title ASC;