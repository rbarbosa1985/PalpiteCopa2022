import { Team } from './Team';
export type PartialResponse = {
  content: PartialType[];
  totalPages: number;
}

export type PartialType = {
  winner: string[];
  vote_winner: number[];
  vice: string[];
  vote_vice: number[];
  third: string[];
  vote_third: [];
}