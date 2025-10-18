SELECT c.item_id, c.item_name, c.rarity
FROM item_info i
JOIN item_tree t
    ON t.parent_item_id = i.item_id
JOIN item_info c
    ON t.item_id = c.item_id
WHERE i.rarity = 'RARE'
ORDER BY c.item_id DESC;