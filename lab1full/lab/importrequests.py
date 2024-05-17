import requests

resp = requests.post("http://localhost:8086/manufacturers", json={"name":"Gigabyte"})
print(resp.status_code, resp.text)

resp = requests.get("http://localhost:8086/manufacturers")
print(resp.status_code, resp.text)
