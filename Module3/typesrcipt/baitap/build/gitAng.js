"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.http = void 0;
const node_fetch_1 = __importDefault(require("node-fetch"));
// Http request api using async/wait
function http(url) {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const response = yield node_fetch_1.default(url);
            const data = yield response.json();
            return data;
        }
        catch (error) {
            console.log("error:");
            console.error(error.message);
            return error;
        }
    });
}
exports.http = http;
const data = http("https://api.github.com/search/repositories?q=angular");
data.then((value) => {
    console.log(value.total_count);
    console.log(`watchers: ${value.items[0].watchers}`);
});
