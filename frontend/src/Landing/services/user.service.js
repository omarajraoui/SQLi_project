import axios from "axios";

const API_URL = "http://localhost:3000/api/collaboraeurs/";

const getPublicContent = () => {
  return axios.get(API_URL + "collaborateurs");
};

const getUserBoard = () => {
  return axios.get(API_URL + "managers");
};

const getAdminBoard = () => {
  return axios.get(API_URL + "admin");
};

const UserService = {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
}

export default UserService;
