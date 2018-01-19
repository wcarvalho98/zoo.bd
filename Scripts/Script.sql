CREATE TRIGGER insere_fatura AFTER INSERT INTO fatura FOR EACH row
BEGIN
	insert into nota_fiscal
	set 
	ICMS = (new.valor * 0.09547),
	valor_total = new.valor + ICMS,
	vl_total_desconto = valor_total * 0.9,
	data_NF = now();
END;
