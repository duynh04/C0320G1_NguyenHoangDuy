import { RequestInfo, Response } from "node-fetch";
import fetch from "node-fetch";

interface Item {
  id: string;
  watchers: number;
}
interface IRepo {
  total_count: number;
  items: Item[];
}
// Http request api using async/wait
export async function http<T>(url: RequestInfo): Promise<T> {
  try {
    const response: Response = await fetch(url);
    const data: T = await response.json();
    return data;
  } catch (error) {
    console.log("error:");
    console.error(error.message);
    return error;
  }
}

const data = http<IRepo>(
  "https://api.github.com/search/repositories?q=angular"
);

data.then((value) => {
  console.log(value.total_count);
  console.log(`watchers: ${value.items[0].watchers}`);
});
