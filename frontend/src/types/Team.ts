export type TeamResponse = {
  content: Team[];
  totalPages: number;
}

export type Team = {
  id: number;
  name: string;
  img_URL: string;
}