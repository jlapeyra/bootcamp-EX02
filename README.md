# bootcamp-EX02

Aquest repositori conté una API que permet gestionar cites d'una clínica dental. La base de dades està continguda dins el projecte i la API es munta a `localhost/8181` .

Els usuaris que hi intervenen són dentista i pacient  Hi ha dos tipus d'endpoints segons l'usuari que hi accedeix:

- Començats per `/dentista/{id}`: hi accedeix el pacient identificat per `{id}`.
- Començats per `/pacient/{id}`: hi accedeix el dentista identificat per `{id}`.

Com que és una versió simplificada, no hi ha procés d'autentificació d'usuaris, simplement s'han d'identificar amb el seu `id` (si l'`id` no és correcte saltarà una excepció). L'únic cas en què no s'han d'identificar és en la creació d'usuaris.



Endpoints del pacient:

- `POST pacient/`. Es crea un usuari pacient
  - Body: `{"nom_cognoms":..., "dni":..., "naixament":...}`
- `GET pacient/{id}`. El pacient consulta el seu usuari
- `PUT pacient/{id}`. El pacient edita el seu usuari
  - Body: `{"nom_cognoms":..., "dni":..., "naixament":...}`
- `POST pacient/{id}/cita`. El pacient crea una cita seva
  - Body: `{"inici":..., "fi":..., ["dentista":{"id":...}]}`
- `PUT pacient/{id}/cita`. El pacient edita una cita seva
  - Body: `{"id":..., "inici":..., "fi":..., ["dentista":{"id":...}]}`
- `DELETE pacient/{id}/cita?idCita` . El pacient elimina una cita seva
- `GET pacient/{id}/cites`. El pacient consulta les seves cites



Endpoints del dentista:

- `POST dentista/`. Es crea un usuari dentista
  - Body: `{"nom_cognoms":..., "dni":..., "naixament":...}`
- `GET dentista/{id}`. El dentista consulta el seu usuari
- `PUT dentista/{id}`. El dentista edita el seu usuari
  - Body: `{"nom_cognoms":..., "dni":..., "num_colegiat":...}`
- `POST dentista/{id}/cita`. El dentista crea una cita (seva o no)
  - Body: `{"inici":..., "fi":..., "pacient":{"id":...}, "dentista":{"id":...}}`
- `PUT dentista/{id}/cita`. El dentista edita una cita seva (seva o no)
  - Body: `{"id":..., "inici":..., "fi":..., "pacient":{"id":...}, "dentista":{"id":...}}`
- `DELETE dentista/{id}/cita?idCita` . El dentista elimina una cita (seva o no)
- `GET dentista/{id}/cites`. El dentista consulta les seves cites
- `GET dentista/{id}/citesTotes`. El dentista consulta totes les cites



Exemples:

- `GET dentista/1` 
- `POST pacient/` Body: `{nom_cognoms": "John Smith", dni": "12345678Z", naixament": "2000-01-01"}`
- `POST pacient/2/cita`  Body: `{"inici": "2023-05-01T15:00:00.000+00:00", "fi": "2023-05-01T15:00:00.000+00:00","dentista":{"id":1}} `
- `PUT dentista/2/cita`  Body: `{"id":1, "inici": "2023-05-01T15:00:00.000+00:00", "fi": "2023-05-01T15:00:00.000+00:00", "pacient": {"id":1},"dentista":{"id":1}} `
- `GET pacient/1/cites`