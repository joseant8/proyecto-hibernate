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





-- relaciones