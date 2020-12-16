
export type MyOrdersListResult = {
  content: MyOrdersResult[],
  pageable: MyOrdersPage,
  totalPages: number,
  totalElements: number,
  last: boolean,
  number: number,
  sort: MyOrdersSort
  size: number,
  numberOfElement: number,
  first: boolean,
  empty: boolean,
}



export type MyOrdersResult = {
  sessionId: string
  receiptNo: string
  supplier: string
  isCancellable: number
  status: string
  statusDescription: string
  approvalPerson: string
  createDate: string
}

export type MyOrdersPage = {
  sort: MyOrdersSort,
  offset: number,
  pageNumber: number,
  pageSize: number,
  paged: boolean,
  unpaged: boolean,
}

export type MyOrdersSort = {
  sorted: boolean,
  unsorted: boolean,
  empty: boolean,
}
export type PollRequest = {
  question: string;
  choices: ChoiceRequest[]
  pollDuration?: PollDuration
}

export type ChoiceRequest = {
  index: number
  text: string
}

export type PollDuration = {
  days: number
  hours: number
}

export type PollResponse = {
  success : boolean
  pollDto : PollDto
}

export type PollDto = {
  id: number
  question: string
  choices?: ChoiceRequest[]
  pollDuration?: PollDuration
}

export type PollSummaryResponse = {
  id: number
  question: string
  choices: ChoiceResponse[]
  username: string
  isActive: boolean
  totalVotes: number
  selectedChoice: number
  updateTime : string
}

export type ChoiceResponse = {
  id: number
  text: string;
  voteCount: number;
}

export type PagedPollSummaryResponse = {
  content: PollSummaryResponse[]
  page: number
  size: number
  totalElements: number
  totalPages: number
  last: number
}





