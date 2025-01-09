# ForoHub API

## Descripción
Esta API gestiona usuarios, temas y autenticación para un foro. Todas las rutas, excepto `/user` y `/login`, requieren autenticación con un token JWT.

---

## Endpoints

### Autenticación
#### `POST /login`
**Descripción:**
Autentica a un usuario y genera un token JWT.

**Request Body:**
```json
{
  "email": "string",
  "password": "string"
}
```

**Response:**
```json
{
  "token": "string"
}
```

---

### Usuarios
#### `POST /user`
**Descripción:**
Crea un nuevo usuario.

**Request Body:**
```json
{
  "name": "string",
  "email": "string",
  "password": "string"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "string",
  "email": "string"
}
```

---

### Tópicos
#### `GET /topicos`
**Descripción:**
Obtiene todos los tópicos registrados.

**Response:**
```json
[
  {
    "title": "string",
    "message": "string",
    "createdAt": "date",
    "status": "string",
    "userEmail": "string",
    "courseName": "string"
  }
]
```

---

#### `GET /topicos/{id}`
**Descripción:**
Obtiene un tópico por su ID.

**Path Parameter:**
- `id`: ID del tópico.

**Response:**
```json
{
  "title": "string",
  "message": "string",
  "createdAt": "date",
  "status": "string",
  "userEmail": "string",
  "courseName": "string"
}
```

---

#### `POST /topicos`
**Descripción:**
Crea un nuevo tópico.

**Request Body:**
```json
{
  "title": "string",
  "message": "string",
  "createdAt": "date",
  "status": "string",
  "user": {
    "email": "string"
  },
  "course": {
    "name": "string"
  }
}
```

**Response:**
```json
{
  "title": "string",
  "message": "string",
  "createdAt": "date",
  "status": "string",
  "userEmail": "string",
  "courseName": "string"
}
```

---

#### `PUT /topicos/{id}`
**Descripción:**
Actualiza los datos de un tópico.

**Path Parameter:**
- `id`: ID del tópico.

**Request Body:**
```json
{
  "title": "string",
  "message": "string",
  "status": "string"
}
```

**Response:**
```json
{
  "title": "string",
  "message": "string",
  "createdAt": "date",
  "status": "string",
  "userEmail": "string",
  "courseName": "string"
}
```

---

#### `DELETE /topicos/{id}`
**Descripción:**
Elimina un tópico por su ID.

**Path Parameter:**
- `id`: ID del tópico.

**Response:**
```json
{
  "message": "Topico eliminado"
}
```

