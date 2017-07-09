Select uit3.tag_id, t3.tag_text, count(*) from user_item_tag uit3, tags t3
where uit3.tag_id = t3.tag_id and uit3.my_usuario_id
in (Select distinct uit2.my_usuario_id from user_item_tag uit2, tags t2
where uit2.tag_id = t2.tag_id and
uit2.tag_id in (Select distinct t.tag_id from tags t, user_item_tag uit
where t.tag_id = uit.tag_id and uit.my_usuario_id = 1) )
group by uit3.tag_id, t3.tag_text

Select uit3.tag_id, t3.tag_text, count(*) from user_item_tag uit3, tags t3
where uit3.tag_id = t3.tag_id and uit3.my_usuario_id = 3
group by uit3.tag_id, t3.tag_text

Select uit3.tag_id, t3.tag_text, count(*) from user_item_tag uit3, tags t3
where uit3.tag_id = t3.tag_id and uit3.item_id = 48
group by uit3.tag_id, t3.tag_text