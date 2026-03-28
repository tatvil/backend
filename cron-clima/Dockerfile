FROM python:3.11-slim
WORKDIR /app
# Instalamos las librerías necesarias para el script
RUN pip install --no-cache-dir requests pymysql
# Copiamos el script al contenedor
COPY weather.py .
# Ejecutamos el script
CMD ["python", "weather.py"]
