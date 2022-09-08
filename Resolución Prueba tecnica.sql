--  Todos los productos del rubro "librería", creados hoy.
SELECT codigo,nombre FROM  producto inner join rubro on producto.id_rubro=rubro.id_rubro 
WHERE fecha_creacion=CURDATE()  and rubro.rubro="librería";

--  Monto total vendido por cliente (mostrar nombre del cliente y monto).
select cliente.nombre, sum(venta.precio_unitario*venta.cantidad) as total_vendido from venta 
inner join cliente on cliente.id_cliente=venta.id_cliente group by venta.id_cliente ;

-- Cantidad de ventas por producto.
select producto.nombre, count(venta.id_venta) as cantidad_ventas from venta 
inner join producto on venta.codigo_producto= producto.codigo group by venta.codigo_producto ;

--  Cantidad de productos comprados por cliente en el mes actual.
select cliente.nombre, sum(venta.cantidad) from venta 
inner join cliente on cliente.id_cliente=venta.id_cliente 
where Date_format(venta.fecha ,'%Y-%m')=Date_format(CURDATE(),'%Y-%m') group by venta.id_cliente ;

--  Ventas que tienen al menos un producto del rubro "bazar".
select venta.id_venta from venta 
inner join producto on venta.codigo_producto=producto.codigo 
inner join rubro on producto.id_rubro=rubro.id_rubro where rubro.rubro="bazar";

-- Rubros que no tienen ventas en los últimos 2 meses.
select rubro from rubro 
inner join producto on producto.id_rubro=rubro.id_rubro
left join venta on venta.codigo_producto=producto.codigo
where venta.codigo_producto is null and venta.fecha between DATE_SUB(CURDATE(),INTERVAL '2' MONTH) and CURDATE() group by rubro.rubro;

