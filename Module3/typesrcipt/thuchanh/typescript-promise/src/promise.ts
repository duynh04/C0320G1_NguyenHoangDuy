import { RequestInfo, Response } from "node-fetch";
import fetch from "node-fetch";

interface Item {
  node_id: string;
  name: string;
  url: string;
}
interface UserRepository {
  [index: number]: Item;
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
  .then((result: UserRepository) => {
    // console.log(result[0]);
    // let val = result as Item[];
    //  result.forEach((value) => console.log(`Url: ${value.url}`));
    for (let index in result) {
      console.log(`---------------------------------------`);
      console.log(`id: ${result[index].node_id}`);
      console.log(`url: ${result[index].url}`);
    }
  })
  .catch((error) => console.error("MyError:", error));
