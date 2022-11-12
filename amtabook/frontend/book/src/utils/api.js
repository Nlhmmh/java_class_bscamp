const domainPath = "http://localhost:8085";

async function getAll(path) {
  try {
    const res = await fetch(domainPath + path, {
      method: "GET",
    });
    return res;
  } catch (error) {
    console.log(error);
  }
  return null;
}

async function post(path, body) {
  try {
    const res = await fetch(domainPath + path, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return res;
  } catch (error) {
    console.log(error);
  }
}
async function put(path, body) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

async function del(path, body) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

export default { getAll, post, put, del };
