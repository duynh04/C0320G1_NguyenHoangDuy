import { RequestInfo, Response } from "node-fetch";
import fetch from "node-fetch";

interface Item {
  node_id: string;
  name: string;
  url: string;
}
// Http request api using promise
function jsonHttpGet(url: RequestInfo): Promise<any> {
  const response = fetch(url);
  return response
    .then((value) => {
      const data = value.json();
      return data;
    })
    .catch((error) => {
      throw new Error(error.message);
    });
}

const data = jsonHttpGet("https://api.github.com/users/NguHoaDuy/repos");

data
  .then((result) => {
    // console.log(value);
    let val = result as Item[];
    val.forEach((value) => console.log(`Url: ${value.url}`));
  })
  .catch((error) => console.error("MyError:", error));
