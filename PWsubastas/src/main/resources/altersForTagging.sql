CREATE TABLE tags
(
  tag_id serial NOT NULL,
  tag_text character varying(50),
  stemmed_text character varying(50),
  CONSTRAINT tag_pkey PRIMARY KEY (tag_id)
);
CREATE TABLE user_item_tag
(
  my_usuario_id serial NOT NULL,
  item_id serial NOT NULL,
  tag_id serial NOT NULL,
  create_date timestamp without time zone,
  CONSTRAINT user_item_tag_pkey PRIMARY KEY (my_usuario_id,item_id,tag_id)
);
