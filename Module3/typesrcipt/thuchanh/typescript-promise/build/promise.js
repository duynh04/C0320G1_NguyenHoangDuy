"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var node_fetch_1 = __importDefault(require("node-fetch"));
// Http request api using promise
function jsonHttpGet(url) {
    var response = node_fetch_1.default(url);
    return response
        .then(function (value) {
        var data = value.json();
        return data;
    })
        .catch(function (error) {
        throw new Error(error.message);
    });
}
var data = jsonHttpGet("https://api.github.com/users/NguHoaDuy/repos");
data
    .then(function (result) {
    // console.log(value);
    var val = result;
    val.forEach(function (value) { return console.log("Url: " + value.url); });
})
    .catch(function (error) { return console.error("MyError:", error); });
