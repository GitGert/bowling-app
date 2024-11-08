import { ReactNode } from "react";

export interface LayoutProps {
  children: ReactNode;
}

export default function Layout({ children }: LayoutProps) {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        backgroundColor: "purple",
        widows: "100vw",
        minHeight: "100vh",
        alignItems: "center",
        padding: "5rem",
      }}
    >
      {children}
    </div>
  );
}
