import defaultLogo from "../../assets/pictures/defaultLogo.jpg";

export interface BowlingTableProps {
  // firstBox: string;
  // secondBox: string;
  // boxScore: number;
  userName: string;
}

// export default function BowlingTable({firstBox, secondBox,  boxScore ,userName} : {bowlingTableProps : BowlingTableProps}) {

// take in an array of user.table from BE
export default function BowlingTable() {
  const oneFrame = (firstBox: string, secondBox: string, boxScore: number) => {
    return (
      <div
        style={{
          display: "flex",
          flexDirection: "row",
          width: "5rem",
          height: "5rem",
          flexWrap: "wrap",
          backgroundColor: "white",
          border: "2px solid black",
          boxSizing: "border-box",
        }}
      >
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            backgroundColor: "blue",
            width: "50%",
            height: "50%",
            borderRight: "1px solid black",
            boxSizing: "border-box",
          }}
        >
          <p>{firstBox}</p>
        </div>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            backgroundColor: "green",
            width: "50%",
            height: "50%",
            borderLeft: "1px solid black",
            boxSizing: "border-box",
          }}
        >
          <p>{secondBox}</p>
        </div>
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            backgroundColor: "grey",
            width: "100%",
            height: "50%",
            borderColor: "black",
            borderTop: "2px solid black",
            boxSizing: "border-box",
          }}
        >
          <p>{boxScore}</p>
        </div>
      </div>
    );
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "row",
        // alignItems: "center",
      }}
    >
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          padding: "30px",
        }}
      >
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            width: "50px", // Set desired dimensions
            height: "50px", // Make it square to ensure it's circular
            overflow: "hidden",
            borderRadius: "50%", // This makes the div round
          }}
        >
          <img
            src={defaultLogo}
            alt="Default Logo"
            style={{
              width: "100%",
              height: "100%",
              objectFit: "cover", // Ensures the image covers the entire div while maintaining aspect ratio
            }}
          />
        </div>
        {"Gert Nõgene"}
      </div>
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {oneFrame("1", "4", 5)}
      {/* FIXME: last on should have 3 tiles on the top */}
    </div>
  );
}
