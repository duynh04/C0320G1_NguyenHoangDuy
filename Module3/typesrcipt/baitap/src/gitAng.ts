import { RequestInfo, Response } from "node-fetch";
import fetch from "node-fetch";

interface Item {
  ID: string;
  Title: number;
}
interface IRepo {
  LtsItem: Item[];
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
  // "https://api.github.com/search/reposiYtories?q=angular"
  "https://thongtindoanhnghiep.co/api/city"
);

data.then((value) => {
  console.log(`watchers: ${value.LtsItem[0].Title}`);
});
