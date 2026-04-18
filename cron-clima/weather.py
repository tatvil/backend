import requests
import pymysql
from datetime import datetime

# -----------------------------
# CONFIGURACIÓN
# -----------------------------
DB_USER = "climauser" 
DB_PASS = "climapass123" 
DB_HOST = "db" 
DB_NAME = "clima"

API_KEY = "69ef7f26726bba12b03c74b1e97b550f"

CIUDADES = [
    "Madrid,ES",
    "Alfas del Pi,ES",
    "L'Ampolla,ES"
]

# -----------------------------
# FUNCIONES
# -----------------------------

def limpiar_nombre_ciudad(nombre):
    reemplazos = {
        'Á':'A','É':'E','Í':'I','Ó':'O','Ú':'U',
        'á':'a','é':'e','í':'i','ó':'o','ú':'u',
        'ñ':'n','Ñ':'N'
    }
    for k, v in reemplazos.items():
        nombre = nombre.replace(k, v)
    return nombre

def convertir_fecha(timestamp):
    return datetime.fromtimestamp(timestamp).strftime("%Y-%m-%d %H:%M:%S")

def obtener_datos_tiempo(ciudad):
    url = f"http://api.openweathermap.org/data/2.5/weather?q={ciudad}&appid={API_KEY}&units=metric"
    try:
        response = requests.get(url, timeout=10)
        response.raise_for_status()
        return response.json()
    except Exception as e:
        print(f"Error obteniendo datos de {ciudad}: {e}")
        return None

def guardar_datos(conn, datos):
    ciudad = limpiar_nombre_ciudad(datos["name"])
    fecha = convertir_fecha(datos["dt"])
    amanecer = convertir_fecha(datos["sys"]["sunrise"])
    anochecer = convertir_fecha(datos["sys"]["sunset"])
    temp_min = datos["main"]["temp_min"]
    temp_max = datos["main"]["temp_max"]
    humedad = datos["main"]["humidity"]
    viento_velocidad = datos["wind"]["speed"]
    viento_direccion = datos["wind"].get("deg", 0)
    nubes = datos["clouds"]["all"]
    lluvia = datos.get("rain", {}).get("1h", 0)

    sql = """
        INSERT INTO weather 
        (fecha, ciudad, amanecer, anochecer, temp_min, temp_max, humedad, viento_velocidad, viento_direccion, nubes, lluvia)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """

    with conn.cursor() as cursor:
        cursor.execute(sql, (fecha, ciudad, amanecer, anochecer, temp_min, temp_max,
                             humedad, viento_velocidad, viento_direccion, nubes, lluvia))
    conn.commit()
    print(f"Datos de {ciudad} guardados correctamente.")

# -----------------------------
# PROGRAMA PRINCIPAL
# -----------------------------

def main():
    try:
        conn = pymysql.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASS,
            database=DB_NAME,
            charset="utf8mb4"
        )
    except Exception as e:
        print("Error conectando a MySQL:", e)
        return

    for ciudad in CIUDADES:
        datos = obtener_datos_tiempo(ciudad)
        if datos:
            guardar_datos(conn, datos)

    conn.close()

if __name__ == "__main__":
    main()

