-- QUERY RELATORIO 1
 
SELECT 

	rp.idregistro as Registro
    ,f.nomefun as Funcionario
    ,f.idfuncionario as ID
    ,f.cpf as Cpf
    ,rp.data as Data_Registro
    ,p.tipo as Tipo
    
FROM
 
	registro_ponto         rp
    inner join funcionario f on ( rp.idfuncionario = f.idfuncionario )
    inner join ponto 	   p on ( rp.idponto = p.idponto )

WHERE 

	f.idfuncionario = 10
    or f.cpf = 05605502190;
    
-- QUERY RELATORIO 2

select avg(rp.data) from registro_ponto rp where rp.idponto = 1;

select cast(avg(rp.data) as time) from registro_ponto rp where rp.idponto = 1 and rp.data between '2018-06-13' and now();

select * from ponto;


















