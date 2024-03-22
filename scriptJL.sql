SELECT CUENTAS.NOMBRE_CTA, COUNT(*) as NUMERO_MOVIMIENTOS FROM CUENTAS c, movimientos m where c.COD_BANCO=m.COD_BANCO AND c.COD_SUCUR=m.COD_SUCUR AND c.NUM_CTA=m.NUM_CTA
group by NOMBRE_CTA having count(*)=(select max(n)                 declaras n como el nombre
									from (select count(*) n        esto es una tabla virt
									from movimientos
                                    group by COD_BANCO, COD_SUCUR, NUM_CTA) c1 )               "esto" es el numero de movimientos 