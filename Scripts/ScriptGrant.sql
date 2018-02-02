USE zoologico;

DROP USER 'admin'@'localhost';
DROP USER 'veterinario'@'localhost';
DROP USER 'tratador'@'localhost';
DROP USER 'secretario'@'localhost';

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON zoologico.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

##################################################################################################################

CREATE USER 'veterinario'@'localhost' IDENTIFIED BY 'vet';

GRANT SELECT ON zoologico.animal TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.consulta TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.consulta TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.consulta TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.consulta TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.diagnostico TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.diagnostico TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.diagnostico TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.diagnostico TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.doenca TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.doenca TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.doenca TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.doenca TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.especie TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.especie TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.especie TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.especie TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.especie_indicada TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.especie_indicada TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.especie_indicada TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.especie_indicada TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.genero TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.genero TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.genero TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.genero TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.medicamento TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.medicamento TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.medicamento TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.medicamento TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.ordem TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.ordem TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.ordem TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.ordem TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.prescricao TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.prescricao TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.prescricao TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.prescricao TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.sintoma TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.sintoma TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.sintoma TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.sintoma TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.trata TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.trata TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.trata TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.trata TO 'veterinario'@'localhost';

GRANT INSERT ON zoologico.tratamento TO 'veterinario'@'localhost';
GRANT DELETE ON zoologico.tratamento TO 'veterinario'@'localhost';
GRANT SELECT ON zoologico.tratamento TO 'veterinario'@'localhost';
GRANT UPDATE ON zoologico.tratamento TO 'veterinario'@'localhost';

FLUSH PRIVILEGES;

##################################################################################################################

CREATE USER 'tratador'@'localhost' IDENTIFIED BY 'trat';

GRANT SELECT ON zoologico.animal TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.doenca TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.especie TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.especie_indicada TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.genero TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.medicamento TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.ordem TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.prescricao TO 'tratador'@'localhost';

GRANT SELECT ON zoologico.sintoma TO 'tratador'@'localhost';

GRANT INSERT ON zoologico.trata TO 'tratador'@'localhost';
GRANT SELECT ON zoologico.trata TO 'tratador'@'localhost';
GRANT UPDATE ON zoologico.trata TO 'tratador'@'localhost';

GRANT INSERT ON zoologico.tratamento TO 'tratador'@'localhost';
GRANT SELECT ON zoologico.tratamento TO 'tratador'@'localhost';
GRANT UPDATE ON zoologico.tratamento TO 'tratador'@'localhost';

FLUSH PRIVILEGES;

##################################################################################################################

CREATE USER 'secretario'@'localhost' IDENTIFIED BY 'sec';

GRANT SELECT ON zoologico.bilheteria TO 'secretario'@'localhost';

GRANT INSERT ON zoologico.empresa_terceira TO 'secretario'@'localhost';
GRANT SELECT ON zoologico.empresa_terceira TO 'secretario'@'localhost';

GRANT INSERT ON zoologico.instituicao TO 'secretario'@'localhost';
GRANT SELECT ON zoologico.instituicao TO 'secretario'@'localhost';

FLUSH PRIVILEGES;