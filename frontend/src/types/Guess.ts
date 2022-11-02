import { Client } from "./Client";
import { Team } from "./Team";

export type GuessResponse = {
  content: Guess[];
  totalPages: number;
  totalElements: number;
}

export type Guess = {
  id: number;
  client: Client;
  winner: Team;
  vice: Team;
  third: Team;
  createdAt: string;
}