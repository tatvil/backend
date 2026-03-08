# Gestión de APIs Java con systemd – Apuntes

## 1. backend
1.1. En local:
```bash
mvn clean package
scp target\formula1-0.0.1-SNAPSHOT.jar tatiana@tatvil.es:/home/tatiana
```

## 1. Comandos básicos de systemd

| Acción | Comando | Qué hace |
|--------|---------|----------|
| Recargar systemd después de cambiar `.service` | `sudo systemctl daemon-reload` | Systemd vuelve a leer todos los archivos de configuración de servicios |
| Reiniciar un servicio | `sudo systemctl restart nombre-del-servicio` | Detiene y arranca de nuevo el servicio (usa cuando cambias `.jar` o configuración) |
| Parar un servicio | `sudo systemctl stop nombre-del-servicio` | Detiene el servicio |
| Arrancar un servicio | `sudo systemctl start nombre-del-servicio` | Inicia el servicio |
| Comprobar estado | `sudo systemctl status nombre-del-servicio` | Muestra si está activo, errores y logs recientes |
| Ver logs en tiempo real | `journalctl -u nombre-del-servicio -f` | Muestra logs del servicio mientras corre |
| Habilitar para que arranque al iniciar el sistema | `sudo systemctl enable nombre-del-servicio` | Asegura que el servicio arranque automáticamente al reiniciar el VPS |

---

## 2. Flujo correcto al cambiar `.service`

1. Editar el archivo `.service`:

```bash
sudo vi /etc/systemd/system/f1api.service
sudo systemctl daemon-reload # recarga systemd
sudo systemctl restart f1api.service #Reinicia el servicio
```

2.  Comprobar estado y logs:
```bash
sudo systemctl status f1api.service
journalctl -u f1api.service -f
```

3️. Flujo al actualizar solo el .jar de tu API


Compilar proyecto local:

mvn clean package

Copiar .jar a /var/www/apis/....

Reiniciar el servicio:

sudo systemctl restart f1api.service

Verificar que funciona:

sudo systemctl status f1api.service

Nota: No hace falta daemon-reload si solo cambias el .jar.

4️⃣ Buenas prácticas

Usuario: Evitar root. Mejor tatiana o tatiana-api.

Carpeta de la app: /var/www/apis/f1api y /var/www/apis/backend. Nada en /home.

Logs: Usa syslog o archivos separados:

StandardOutput=syslog
StandardError=syslog
SyslogIdentifier=f1api

RestartSec: Define segundos de espera entre reinicios automáticos:

RestartSec=5
5️⃣ Comandos útiles extras
# Ver todos los servicios que corren
systemctl list-units --type=service

# Habilitar servicio para iniciar al arrancar
sudo systemctl enable f1api.service

# Deshabilitar servicio
sudo systemctl disable f1api.service
6️⃣ Flujo profesional recomendado
Local (tu ordenador)
   ↓ compilar .jar
   ↓ copiar a VPS (/var/www/apis)
   ↓ systemctl restart nombre-del-servicio
   ↓ revisar logs con journalctl

Para cambios en el .service, primero daemon-reload y luego restart.

Mantener producción y staging separados (/var/www/apis/... y /var/www/apis-staging/...).

Frontend separado en /var/www/villaema.