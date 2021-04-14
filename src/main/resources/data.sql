-- usuarios
insert into user (nombre, apellido, dni, activo, fecha_nacimiento) values ("Juan", "Martínez", "12345678M", true, "1990-01-22");
insert into user (nombre, apellido, dni, activo, fecha_nacimiento) values ("Antonio", "Alonso", "32345679T", true, "1988-05-15");
insert into user (nombre, apellido, dni, activo, fecha_nacimiento) values ("Sofía", "Fonseca", "52345680F", true, "1986-06-12");
insert into user (nombre, apellido, dni, activo, fecha_nacimiento) values ("Marta", "Gómez", "72345680P", false, "1992-06-10");

-- tareas
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega1", "Entrega del proyecto 1", "2021-03-14", true);
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega2", "Entrega del proyecto 2", "2021-04-25", false);
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega3", "Entrega del proyecto 3", "2021-04-10", true);
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega4", "Entrega del proyecto 4", "2021-04-13", true);
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega5", "Entrega del proyecto 5", "2021-05-15", false);
insert into task (titulo, descripcion, fecha_entrega, finalizada) values ("Entrega6", "Entrega del proyecto 6", "2021-05-20", false);

-- etiquetas
insert into tag (nombre, color) values ("Refactorizar", 0);
insert into tag (nombre, color) values ("Implementar", 1);
insert into tag (nombre, color) values ("Testear", 2);
insert into tag (nombre, color) values ("ArreglarFallo", 3);

-- facturación
insert into billing_info (direccion, telefono) values ("Calle Rosa García Ascot, Málaga", "000100200");
insert into billing_info (direccion, telefono) values ("Av Paseo de la Castellana, Madrid", "100500800");
insert into billing_info (direccion, telefono) values ("Calle de la Paz, Valencia", "600500900");
insert into billing_info (direccion, telefono) values ("Av Paseo de Cristóbal Colón, Sevilla", "500500900");



-----Establecemos relaciones-----

-- relaciones usuario-facturación
update user set billing_id=1 where id=1;
update user set billing_id=2 where id=3;
update user set billing_id=3 where id=2;
update user set billing_id=4 where id=4;

-- relaciones tareas-usuario
update task set user_id=1 where id=1;
update task set user_id=1 where id=2;
update task set user_id=2 where id=3;
update task set user_id=3 where id=4;
update task set user_id=3 where id=5;
update task set user_id=4 where id=6;

-- relaciones tareas-etiquetas
insert into task_tag (task_id, tag_id) values (1, 2);
insert into task_tag (task_id, tag_id) values (1, 3);
insert into task_tag (task_id, tag_id) values (2, 1);
insert into task_tag (task_id, tag_id) values (2, 4);
insert into task_tag (task_id, tag_id) values (2, 3);
insert into task_tag (task_id, tag_id) values (3, 2);
insert into task_tag (task_id, tag_id) values (4, 1);
insert into task_tag (task_id, tag_id) values (5, 4);
insert into task_tag (task_id, tag_id) values (5, 3);
insert into task_tag (task_id, tag_id) values (6, 1);